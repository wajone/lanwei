
    $(function(){
    $("#sid1").change(function(obj){
        var citys = [["郑州市","开封市","洛阳市","平顶山市"],
            ["石家庄市","唐山市","秦皇岛市","邯郸市"],
            ["长沙市","湘潭市","岳阳市","衡阳市"],
            ["武汉市","黄石市","十堰市","宜昌市"]];
        var selectObj1 = $("#sid1");
        var selectObj2 = $("#sid2");
        selectObj2.empty();
        $("#sid1 option").each(function(i,obj){
            selectObj2.append("<option>"+citys[selectObj1.val()][i]+"</option>")
        })
    })
})
