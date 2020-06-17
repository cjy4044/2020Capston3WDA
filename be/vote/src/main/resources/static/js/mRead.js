$(document).ready(function(){
    
    var audience = {
        applyId : $('#applyId').val()
    }
    console.log($('#applyId').val());
    $('#showRecruits').click(function(){
        $.ajax({
            url: "/audience/showRecruits",
            type: "get",
            dataType: 'json',
            data : audience,
            success: function(data){
        
                console.log(data);
                // var tableData = "";

                // $.each(data.member[0], function(index, value) {
                //     console.log(index);
                //     console.log("value : " + value);
                //     tableData += '<tr>';
                //     tableData += '<td>'+value+'</td>';
                //     tableData += '<td>'+value+'</td>';
                //     tableData += '</tr>';
                // });
    
                // $("#list").append(tableData);
        
            },
        
            error:function(request,status,error){
                alert("code = "+ request.status + " message = " + request.responseText + " error = " + error); // 실패 시 처리
               }
        
    
        
          });
    })
       
    
    
    

})


