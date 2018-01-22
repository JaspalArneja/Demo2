
	function deleteUserRecord(id)
	{
		//alert("deleted"+id);
		$.ajax({
            type: "POST",
            url: "delete.action",
            data: {id : id}, // serializes the form's elements.
            success: function(data)
            {
                alert(data.msg); // show response from the jsp script.
                $("#showli" ).click();
            }
          });
		
	}
	
	function fetchUserRecord(obj,id)
		{
		var name=$("#name"+id).text().trim();
		var email=$("#email"+id).text().trim();
		var phone=$("#phone"+id).text().trim();
		var age=$("#age"+id).text().trim();
		var pass=$("#pass"+id).val().trim();
		var country=$("#country"+id).text().trim();
		var state=$("#state"+id).text().trim();
		var city=$("#city"+id).text().trim();
		var address=$("#street_address"+id).text().trim();
		var countryid=$("#countryid"+id).val().trim();
		var stateid=$("#stateid"+id).val().trim();
		var cityid=$("#cityid"+id).val().trim();
		$("#uname").val(name);
		$("#uemailid").val(email);
		$("#unumber").val(phone);
		$("#uage").val(age);
		$("#upass").val(pass);
		$("#myid").val(id);
		$("#uaddress").val(address);
		var options = $("#countryId > option").clone();

		$('#ucountryId').html(options);
		$('#ucountryId option:contains("'+country+'")').prop('selected', true);
		//alert($("#ucountryId").val());
		$.ajax({
			url : 'getState.jsp',
                        data : {
				ccode : $("#ucountryId").val()
			},
	        async:false,
			success : function(responseText) {
                            //alert(responseText+country_id);
				$('#ustateId').html(responseText);
			}
		});
		
		$('#ustateId option:contains("'+state+'")').prop('selected', true);
		//alert($("#ustateId").val());
		 $.ajax({
				url : 'getCity.jsp',
		        async:false,
	                        data : {
					scode : $("#ustateId").val()
				},
				
				success : function(responseText) {
	                            //alert(responseText+country_id);
					$('#ucityId').html(responseText);
				}
			});
		 $('#ucityId option:contains("'+city+'")').prop('selected', true);
		
		}
	
		$(document).ready(function(){


			 $("#countryId").change(function(){
	                $.ajax({
				url : 'getState.jsp',
	                        data : {
					ccode : $("#countryId").val()
				},success : function(responseText) {
	                            //alert(responseText+country_id);
					$('#stateId').html(responseText);
				}
			});
	            
	        });
	        $("#stateId").change(function(){
	                $.ajax({
				url : 'getCity.jsp',
	                        data : {
					scode : $("#stateId").val()
				},success : function(responseText) {
	                            //alert(responseText+country_id);
					$('#cityId').html(responseText);
				}
			});
	            
	        });
	        $("#ucountryId").change(function(){
                $.ajax({
			url : 'getState.jsp',
                        data : {
				ccode : $("#ucountryId").val()
			},success : function(responseText) {
                            //alert(responseText+country_id);
				$('#ustateId').html(responseText);
			}
		});
            
        });
        $("#ustateId").change(function(){
                $.ajax({
			url : 'getCity.jsp',
                        data : {
				scode : $("#ustateId").val()
			},success : function(responseText) {
                            //alert(responseText+country_id);
				$('#ucityId').html(responseText);
			}
		});
            
        });
			
	        $("#showli").click(function(){
		       $.ajax({
	                type: "POST",
	                url: "show.action",
	                success: function(result)
	                {
		                  var tblData="";
		                  var count=0;
						 $.each(result.bean, function() {
							 	count++;			
						 tblData += "<tr><td>" + count + "</td>" + 
						"<td id='name"+this.id+"'>" + this.name + "</td>" + 
						"<td id='email"+this.id+"'>" + this.email + "</td>" + 
						"<td id='phone"+this.id+"'>" + this.phone + "</td>" + 
						"<td id='age"+this.id+"'>" + this.age + "</td>" + 
						"<td id='country"+this.id+"'>" + this.country + "<input type=hidden id='countryid"+this.id+"' value="+this.countryid+"></td>" + 
						"<td id='state"+this.id+"'>" + this.state + "<input type=hidden id='stateid"+this.id+"' value="+this.stateid+"></td>" + 
						"<td id='city"+this.id+"'>" + this.city + "<input type=hidden id='cityid"+this.id+"' value="+this.cityid+"><input type=hidden id='pass"+this.id+"' value="+this.password+"></td>" + 
						"<td id='street_address"+this.id+"'>" + this.street_address +
						"<td><button type=submit onclick='fetchUserRecord(this,"+this.id+");' data-toggle='modal' data-target='#updateModal' class='btn btn-primary' id='updateaction'>Update</button></td><td><button type=submit onclick='deleteUserRecord("+this.id+");' id=deletebtn class='btn btn-danger' >Delete</button></td>" +"</tr>" ; 
						});
						if(count==0)
							{
							tblData += "<tr><td colspan=11>No Users Found!!!</td></tr>" ;
							}
						$("#showuserlist").html(tblData);
	                    //
	                },
	                error: function(errorMessage){alert(errorMessage);}
	              });
		        });
	        
			$("#registerform").submit(function(e)
					{
				//
				  	
  	  	var url = "register.action";
  	  	$.ajax({
            type: "POST",
            url: url,
            data: $("#registerform").serialize(), // serializes the form's elements.
            success: function(data)
            {
                alert(data.msg); // show response from the jsp script.
                $("#name").val();
                $("#email").val();
                $("#pass").val();
                $("#age").val();
                $("#phone").val();
                $("#address").val();
                
                $("#showli" ).click();
            }
          });

     			e.preventDefault();
				//
				});
			$("#updateform").submit(function(e)
					{
				//
				  	
  	  	var url = "update.action";
  	  	$.ajax({
            type: "POST",
            url: url,
            data: $("#updateform").serialize(), // serializes the form's elements.
            success: function(data)
            {
                alert(data.msg); // show response from the jsp script.
                
                //$("#updateModal").dismiss();
                $("#showli" ).click();
            }
          });

     			e.preventDefault();
				//
				});
			 $.ajax({
					url : 'getCountry.jsp',
					
					success : function(responseText) {
		                            //alert(responseText);
						$('#countryId').append(responseText);
					}
				});

			 $('#show_password').hover(function functionName() {
					//Change the attribute to text
					$('#upass').attr('type', 'text');
					$('.glyphicon').removeClass('glyphicon-eye-open').addClass('glyphicon-eye-close');
				}, function () {
					//Change the attribute back to password
					$('#upass').attr('type', 'password');
					$('.glyphicon').removeClass('glyphicon-eye-close').addClass('glyphicon-eye-open');
				}
			);

				
			});
	