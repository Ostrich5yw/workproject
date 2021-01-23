<%--
  Created by IntelliJ IDEA.
  User: PanGPanG5
  Date: 2021/1/15
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>menu</title>
    <link rel="stylesheet" href="layuimini/lib/layui-v2.5.5/css/layui.css" media="all">
    <link rel="stylesheet" href="layuimini/css/public.css" media="all">
    <style>
        .layui-btn:not(.layui-btn-lg ):not(.layui-btn-sm):not(.layui-btn-xs) {
            height: 34px;
            line-height: 34px;
            padding: 0 8px;
        }
    </style>
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">
        <div>
            <div class="layui-btn-group">
                <button class="layui-btn" id="btn-expand">全部展开</button>
                <button class="layui-btn layui-btn-normal" id="btn-fold">全部折叠</button>
            </div>
            <table id="munu-table" class="layui-table" lay-filter="munu-table"></table>
        </div>
    </div>
</div>
<!-- 操作列 -->
<script type="text/html" id="tbBar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="edit">修改</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
    <a class="layui-btn layui-btn-warm layui-btn-xs" lay-event="addfile">添加</a>

</script>

<script src="layuimini/lib/layui-v2.5.5/layui.js" charset="utf-8"></script>
<script src="layuimini/js/lay-config.js?v=2.0.0" charset="utf-8"></script>
<script>
    layui.use(['table', 'treetable'], function () {
        var $ = layui.jquery;
        var table = layui.table;
        var treetable = layui.treetable;

        // 渲染表格
        layer.load(2);
        var tt = treetable.render({
            treeColIndex: 1,
            treeSpid: -1,
            treeIdName: 'authorityId',
            treePidName: 'parentId',
            elem: '#munu-table',
            url: 'layuimini/api/test.json',
            tree: {
                iconIndex: 1,
                isPidData: true,
                idName: 'authorityId',
                pidName: 'parentId',
                arrowType: 'arrow2',
                getIcon: 'ew-tree-icon-style2'
            },
            // toolbar: 'default',
            cols: [[
                {type: 'numbers'},
                {field: 'authorityName', minWidth: 200, title: '权限名称<i class=\"layui-icon\">&#xe642;</i>',edit: 'text'},
                {field: 'authority', title: '权限标识<i class=\"layui-icon\">&#xe642;</i>',edit: 'text'},
                {field: 'menuUrl', title: '菜单url'},
                {field: 'orderNumber', width: 80, align: 'center', title: '排序号'},
                {
                    field: 'isMenu', width: 80, align: 'center', templet: function (d) {
                        if (d.isMenu == 1) {
                            return '<span class="layui-badge layui-bg-gray">按钮</span>';
                        }
                        if (d.parentId == -1) {
                            return '<span class="layui-badge layui-bg-blue">目录</span>';
                        } else {
                            return '<span class="layui-badge-rim">菜单</span>';
                        }
                    }, title: '类型'
                },
                {align: 'center', toolbar: '#tbBar', title: '操作', width: 120}
            ]],
            done: function () {
                layer.closeAll('loading');
            }
        });

        $('#btn-expand').click(function () {
            tt.expandAll('#munu-table');
        });

        $('#btn-fold').click(function () {
            tt.foldAll('#munu-table');
        });

        //监听工具条
        treetable.on('tool(munu-table)', function (obj) {
            var data = obj.data;
            var layEvent = obj.event;
            if (layEvent === 'del') {
                menudelete(obj)
                // layer.load(2)
                // tt.reload({url: 'layuimini/api/test.json'})
                // console.log(tt.options.data)
                obj.del()
            } else if (layEvent === 'edit') {
                menuupdate(obj)
                // layer.msg('修改' + data.id);
                obj.update()
            } else if (layEvent === 'addfile') {
                // console.log(obj)
            }
        });
        //***************************************************************************************自定义方法
        function menudelete(obj){
            var optiondata = $.extend(true, {}, tt.options.data)
            var tree = tt.options.data[0]              //tt.options.data中存放着整个树
            var delNode = obj.data.authorityId              //delNode记录待删除的节点号
            var delParent
            var delLength = 1                               //记录一共删除的节点个数
            var mark = false
            // console.log(tree)
            let node = []
            let res = []
            node.push(tree)
            while(node.length != 0){                        //使用一个队列实现遍历整棵树
                var temp = node.shift()
                if(node.length != 0)
                    var temp2 = node[0]

                if(temp.authorityId != delNode) {
                    if (mark) {
                        temp.authorityId -= delLength
                        temp.orderNumber -= delLength
                        if (temp.parentId > delParent)
                            temp.parentId -= delLength
                    }
                    res.push(temp)
                }
                if(temp.authorityId == delNode && !mark) {           //如果当前节点是待删除根节点，判断其是否为目录，删除其所有子节点并将其标记为-2
                    // console.log(delNode)
                    if (temp.isMenu == 0) {                  //并计算出删除的总结点数
                        delLength += (temp2.authorityId - temp.authorityId - 1);    //删除的节点数就是它自己加上它的子节点(下一个同级目录与它的序号差值)
                        temp.authorityId = -2
                        delete temp.children
                    } else {
                        temp.authorityId = -2
                    }
                    mark = true
                    delParent = temp.parentId
                }
                if(temp.children != undefined)                  //继续向后遍历
                    for(var i = temp.children.length - 1; i >= 0; i--){
                        node.unshift(temp.children[i])
                    }
            }
            // console.log(tree)
            // console.log(delLength)
            // console.log(res)
            for(var i = 0; i < res.length;i ++){
                delete res[i].children
                delete res[i].LAY_INDEX
                delete res[i].open
                res[i] = JSON.stringify(res[i])
            }
            // console.log(res)
            $.ajax({
                url:'/request/changeJson',
                type:'POST',
                async: false,
                traditional: true,
                data:{"res": res},
                success:function(response){
                    //请求成功后执行的代码
                    // alert("success")
                },
                error:function(status){
                    //失败后执行的代码
                    // alert("fail")
                }
            })
            tt.options.data = optiondata
        }
        function menuupdate(obj){
            var tree = $.extend(true, {}, tt.options.data[0])             //tt.options.data中存放着整个树
            var updateNode = obj.data.authorityId              //delNode记录待删除的节点号
            let node = []
            let res = []
            node.push(tree)
            while(node.length != 0) {                        //使用一个队列实现遍历整棵树
                var temp = node.shift()
                if(temp.authorityId == updateNode){
                    // console.log(temp)
                    // console.log(obj.data)
                    // temp = obj.data;

                }
                console.log(temp)
                res.push(temp)
                if(temp.children != undefined)                  //继续向后遍历
                    for(var i = temp.children.length - 1; i >= 0; i--){
                        node.unshift(temp.children[i])
                    }
            }
            for(var i = 0; i < res.length;i ++){
                delete res[i].children
                delete res[i].LAY_INDEX
                delete res[i].open
                res[i] = JSON.stringify(res[i])
            }
            console.log(res)
            $.ajax({
                url:'/request/changeJson',
                type:'POST',
                async: false,
                traditional: true,
                data:{"res": res},
                success:function(response){
                    //请求成功后执行的代码
                    // alert("success")
                },
                error:function(status){
                    //失败后执行的代码
                    // alert("fail")
                }
            })
            console.log(tt.options.data)
        }
    });


</script>
</body>
</html>
