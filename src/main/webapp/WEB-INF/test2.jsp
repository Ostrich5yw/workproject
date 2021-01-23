<%--
  Created by IntelliJ IDEA.
  User: PanGPanG5
  Date: 2021/1/10
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>树组件</title>
    <link rel="stylesheet" href="layui/css/layui.css">
</head>
<body>
<div id="test1"></div>
<script src="layui/layui.js"></script>
<script src="js/jquery.min.js"></script>
<script>
    var data;
    function doit() {
        // $.ajax({
        //     type: "GET",
        //     url: "/json/user.json",
        //     async: false,
        //     success: function(response){
        //         console.log(response)
        //         data = response;
        //     }
        // });
        data =JSON.parse('${UserTree}')
        console.log(data)
    }
    doit();
    layui.use('tree', function(){
        var tree = layui.tree;

        //渲染
        var inst1 = tree.render({
            elem: '#test1' , //绑定元素
            edit: ['add', 'del']
            // ,data: data.user1
            ,data: data,

        });
    });
</script>
</body>
</html>
