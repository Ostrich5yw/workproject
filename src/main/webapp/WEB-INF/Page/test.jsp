<%--
  Created by IntelliJ IDEA.
  User: PanGPanG5
  Date: 2021/1/21
  Time: 16:42
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
        <blockquote class="layui-elem-quote">
            Layui的树形表格treeTable，支持异步加载(懒加载)、复选框联动、折叠状态记忆。<br>
            <a href="https://gitee.com/whvse/treetable-lay" target="_blank" class="layui-btn layui-btn-danger">treetable-lay</a>
        </blockquote>
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
            url: 'layuimini/api/menus.json',
            tree: {
                iconIndex: 1,
                isPidData: true,
                idName: 'authorityId',
                pidName: 'parentId',
                arrowType: 'arrow2',
                getIcon: 'ew-tree-icon-style2'
            },
            toolbar: 'default',
            cols: [[
                {type: 'numbers'},
                {field: 'authorityName', minWidth: 200, title: '权限名称'},
                {field: 'authority', title: '权限标识'},
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

        treetable.on('tool(munu-table)', function (obj) {
            var event = obj.event;
            if (event === 'del') {
                layer.msg('删除成功');
                obj.del();
                tt.reload()
                console.log(tt.options)
                tt.expandAll()
            } else if (event === 'edit') {
                layer.msg('修改成功');
                obj.update({authorityName: '新的名称'});
            }
        });

    });
</script>
</body>
</html>