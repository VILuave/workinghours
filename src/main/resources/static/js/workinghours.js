/**
 * 使用jquery datatable插件构建工时管理页面.
 *
 * Created by goldendba@gmail.com on 2017/3/8.
 */
$(function () {
    var datatables_options = {
        ajax: {
            url: "/wk/list",
            "dataSrc": ""
        },
        "dom": "<'row'<'#toolbar.col-xs-2'l><'#params.col-xs-4'><'col-xs-6'f>r>" + "t" + "<'row'<'col-xs-6'i><'col-xs-6'p>>",
        "bAutoWidth": true,
        "bPaginate": true,
        "sPaginationType": "full_numbers",
        "iDisplayLength": 10,
        "bSort": true,
        "bFilter": false,
        "bInfo": false,
        "bStateSave": false,
        "iCookieDuration": 0,
        "bScrollAutoCss": true,
        "bProcessing": true,
        "bJQueryUI": false,
        "language": {
            "lengthMenu": "_MENU_ 条记录每页",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)",
            "paginate": {
                "previous": "上一页",
                "next": "下一页"
            }
        },
        columns: [
            {"data": "id"},
            {"data": "createTime"},
            {"data": "createTime"},
            {"data": "createTime"},
            {"data": "seq"},
            {"data": "createTime"},
            {"data": "createTime"},
            {"data": "acceptCount"},
            {"data": "basicWk"},
            {"data": "assistWk"},
            {"data": "qualifiedCount"},
            {"data": "compromiseCount"},
            {"data": "standbyCount"},
            {"data": "rejectCount"},
            {"data": "rejectCount"},
            {"data": "rejectCount"}
        ],
        columnDefs: [
            {
                targets: 0,
                render: function (data, type, row) {
                    var context =
                    {
                        func: [
                            {
                                "name": "修改",
                                "fn": "edit(\'" + c.name + "\',\'" + c.position + "\',\'" + c.salary + "\',\'" + c.start_date + "\',\'" + c.office + "\',\'" + c.extn + "\')",
                                "type": "primary"
                            },
                            {"name": "删除", "fn": "del(\'" + c.name + "\')", "type": "danger"}
                        ]
                    };
                    return template(context);
                }
            }

        ],
        initComplete: function () {
            $("#toolbar").append('<button id="addBtn" type="button" class="btn btn-primary btn-sm">增加计件工时</button>');
        }
    };

    datatables_options["sScrollY"] = "450px";
    datatables_options["sScrollX"] = "100%";
    datatables_options["bScrollCollapse"] = true;
    datatables_options["sScrollXInner"] = '150%';

    var table = $("#example1").DataTable(datatables_options);
    new $.fn.dataTable.FixedColumns(table, {"iLeftColumns": 7});

    /**
     * 新增选中以及删除事件.
     */
    $('#example1 tbody').on('click', 'tr', function () {
        if ($(this).hasClass('selected')) {
            $(this).removeClass('selected');
        }
        else {
            table.$('tr.selected').removeClass('selected');
            $(this).addClass('selected');
        }
    });

    $("#addBtn").click(function () {
        window.location = '/wk/edit';
    });
    
    var del = function(){
        
    }
    
    var edit = function(){
        
    }

    $('#delBtn').click(function () {
        table.row('.selected').remove().draw(false);
    });

    $("#check-all").click(function () {
        var val = $(this).prop("checked");
        $("input[type='checkbox']", ".DTFC_Cloned").attr("checked", val);
        $("#check-all").attr("checked", val);
        if (val) {
            $(this).parent().addClass("checked");//这里需要注意的是js会自动加上一个class,checked,需要加上才有选中效果
        } else {
            $(this).parent().removeClass("checked");
        }
    });
});