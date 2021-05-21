/**
 * Created by goldendba@gmail.com on 2017/3/8.
 */
$(function () {
    var datatables_options = {
        "dom": '<"toolbar">frtip',
        "bAutoWidth": true,
        "bPaginate": false,
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
            "lengthMenu": "每页 _MENU_ 条记录",
            "zeroRecords": "没有找到记录",
            "info": "第 _PAGE_ 页 ( 总共 _PAGES_ 页 )",
            "infoEmpty": "无记录",
            "infoFiltered": "(从 _MAX_ 条记录过滤)"
        }
    };

    datatables_options["sScrollY"] = "450px";
    datatables_options["sScrollX"] = "100%";
    datatables_options["bScrollCollapse"] = true;
    datatables_options["sScrollXInner"] = '150%';

    var table = $("#example1").DataTable(datatables_options);
    new $.fn.dataTable.FixedColumns(table, {"iLeftColumns": 7});
    $("div.toolbar").html('<b style="color:red">自定义文字、图片等等</b>');

    /*$("#check-all").click(function(){
     var val = $(this).prop("checked");
     $("input[type='checkbox']",".DTFC_Cloned").attr("checked",val);
     $("#check-all").attr("checked",val);
     if(val){
     $(this).parent().addClass("checked");//这里需要注意的是js会自动加上一个class,checked,需要加上才有选中效果
     }else{
     $(this).parent().removeClass("checked");
     }
     });*/
});