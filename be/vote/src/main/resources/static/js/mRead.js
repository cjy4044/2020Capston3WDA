$(document).ready(function(){
    
    var audience = {
        applyId : $('#applyId').val()
    }
    console.log(audience);
    $('#showRecruits').click(function(){
        $.ajax({
            url: "/audience/showRecruits",
            type: "get",
            dataType: "html",
            data : audience,
            success: function(data){
        
     
                $("#list").html(data);
                alert(data);
        
                
        
            },
        
            error: function (request, status, error){        
        
        
        
            }
        
          });
    })
       
    
    
    

})


