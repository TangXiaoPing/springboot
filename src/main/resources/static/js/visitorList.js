var pageCurr;
$(function () {
    layui.use('table', function () {
        var table = layui.table
            , form = layui.form;

        tableIns = table.render({
            elem: '#visitorList'
            , url: '/visitor/getVisitorList'
            , method: 'get' //默认：get请求
            , cellMinWidth: 80
            , page: true
            , request: {
                pageName: 'page' //页码的参数名称，默认：page
                , limitName: 'limit' //每页数据量的参数名，默认：limit
            }, response: {
                statusName: 'code' //数据状态的字段名称，默认：code
                , statusCode: 200 //成功的状态码，默认：0
                , countName: 'totals' //数据总数的字段名称，默认：count
                , dataName: 'list' //数据列表的字段名称，默认：data
            }
            , cols: [[ //表头
                {field: 'visitorName', title: '访问者姓名', sort: true, fixed: 'left'}
                , {field: 'visitorPhone', title: '访问者电话'}
                , {field: 'dormRoomId', title: '访问宿舍id'}
                , {field: 'studentId', title: '访问学生id'}
                , {
                    field: 'visitorTime',
                    title: '访问时间',
                    templet: '<div>{{ Format(d.visitorTime,"yyyy-MM-dd hh:mm:ss")}}</div>}'
                }
                , {
                    field: 'goAwayTime',
                    title: '离开时间',
                    templet: '<div>{{ Format(d.goAwayTime,"yyyy-MM-dd hh:mm:ss")}}</div>}'
                }
                , {fixed: 'right', align: 'center', toolbar: '#optBar'}
            ]]
            , done: function (res, curr, count) {
                //如果是异步请求数据方式，res即为你接口返回的信息。
                //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
                // console.log(res);
                //得到当前页码
                // console.log(curr);
                //得到数据总量
                // console.log(count);
                $("[data-field='status']").children().each(function () {
                    if ($(this).text() == '0') {
                        $(this).text("已处理")
                    } else {
                        $(this).text("未处理")
                    }
                });
            }
        });

        //监听工具条
        table.on('tool(foodInfoTable)', function (obj) {
            var data = obj.data;
            $("#appId").val(data.id);
            if (obj.event === 'editFoodInfo') {
                layer.open({
                    type: 2,
                    title: '编辑商品',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['60%', '70%'],
                    content: '/foodInfo/toEditFoodInfo?foodInfoId=' + data.foodInfoId
                });
            }

            if (obj.event === 'lookFoodInfo') {
                layer.open({
                    type: 2,
                    title: '查看商品',
                    shadeClose: true,
                    shade: 0.8,
                    area: ['60%', '70%'],
                    content: '/foodInfo/getFoodInfoById?foodInfoId=' + data.foodInfoId
                });
            }

            if (obj.event === 'delFoodInfo') {
                $.post("/foodInfo/delFoodInfoById", {'foodInfoId': data.foodInfoId}, function (data) {
                    if (data.success) {
                        layer.alert("删除成功", function (index) {
                            window.parent.location.reload();//刷新父页面
                            var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                            parent.layer.close(index); //再执行关闭
                        });
                    } else {
                        layer.alert(data.message);
                    }
                }).error(function () {
                    layer.alert("删除失败");
                });
            }
        });
    });
    //搜索框
    layui.use(['form', 'laydate'], function () {
        var form = layui.form, layer = layui.layer
            , laydate = layui.laydate;
        //TODO 数据校验
        //监听搜索框
        form.on('submit(searchSubmit)', function (data) {
            //重新加载table
            load(data);
            return false;
        });
    });
});

function hoverOpenImg() {
    var img_show = null; // tips提示
    $('td img').hover(function () {
        var kd = $(this).width();
        kd1 = kd * 3;          //图片放大倍数
        kd2 = kd * 3 + 30;       //图片放大倍数
        var img = "<img class='img_msg' src='" + $(this).attr('src') + "' style='width:" + kd1 + "px;' />";
        img_show = layer.tips(img, this, {
            tips: [2, 'rgba(41,41,41,.5)']
            , area: [kd2 + 'px']
        });
    }, function () {
        layer.close(img_show);
    });
    $('td img').attr('style', 'max-width:70px;display:block!important');
}

function Format(datetime, fmt) {
    if (parseInt(datetime) == datetime) {
        if (datetime.length == 10) {
            datetime = parseInt(datetime) * 1000;
        } else if (datetime.length == 13) {
            datetime = parseInt(datetime);
        }
    }
    datetime = new Date(datetime);
    var o = {
        "M+": datetime.getMonth() + 1,                 //月份
        "d+": datetime.getDate(),                    //日
        "h+": datetime.getHours(),                   //小时
        "m+": datetime.getMinutes(),                 //分
        "s+": datetime.getSeconds(),                 //秒
        "q+": Math.floor((datetime.getMonth() + 3) / 3), //季度
        "S": datetime.getMilliseconds()             //毫秒
    };
    if (/(y+)/.test(fmt))
        fmt = fmt.replace(RegExp.$1, (datetime.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt))
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
}

function load(obj) {
    //重新加载table
    tableIns.reload({
        where: obj.field
        , page: {
            curr: pageCurr //从当前页码开始
        }
    });
}









