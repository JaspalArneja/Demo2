<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>


<html>
<head>
    <title>Struts2 Demo</title>
         <meta name="viewport" content="width=device-width, initial-scale=1">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
         <link rel="stylesheet" href="css/style.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script src="js/js1.js"></script>
	
</head>
<body>


  <div class="container">
            <div class="heading text-center">
                <h1><b>Struts CRUD Demo</b></h1>
                
            </div>
            
            <div class="row content reg">
            	<div class="col-sm-8 col-sm-offset-2">
					<div class='well'>
					
					<ul class="nav nav-tabs tabs">
 						<li class="active" id="registerli"><a data-toggle="tab" href="#register">Register User</a></li>
 						 <li id="showli"><a data-toggle="tab" href="#show">Show Users</a></li>
 						
					</ul>
					
					<div class="tab-content">
  						<div id="register" class="tab-pane fade in active">
    						<h3 class='text-center'>Registration</h3>
    						
    						
    					<form method="post" id="registerform">
               
  <div class="form-group ">
    <label for="name">Name:</label>
    <input type="text"  class="form-control" placeholder="Enter Name here" id="name" name="name" required>
  </div>
   <div class="form-group ">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter Email id here" name="email" id="emailid" required>
   
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password here" name="password" id="pass" required>
  </div>
  <div class="form-group ">
    <label for="age">Age:</label>
    <input type="text" class="form-control" onkeypress='return isNumber(event,this.value)' name="age" placeholder="Enter Age here" id="age" required>
  </div>
  <div class="form-group ">
    <label for="phone">Mobile Number:</label>
    <input type="text" class="form-control" name="phone" onkeypress='return isNumber(event,this.value)' placeholder="Enter Mobile Number here" id="number" required>
  </div>
                                 
                                 
                                  <div class="form-group">
                                      <label for="Address">Select Country:</label>
  
        <select name="country" class="form-control countries" id="countryId" name="country" required="required">
<option value="Select Country">Select Country</option>
</select>
    </div>
 <div class="form-group"> 
     <label for="Address">Select State:</label>
  
        <select name="state" class="form-control states" id="stateId" name="state" required="required">
<option value="">Select State</option>
</select>
 
</div>
 <div class="form-group"> 
   <label for="Address">Select City:</label>
  
        <select name="city" class="form-control cities" id="cityId" name="city" required="required">
<option value="">Select City</option>
</select>
 </div>
<div class="form-group ">
    <label for="Address">Enter Street Address:</label>
    <textarea required  class="form-control" placeholder="Enter Address here" name="street_address" id="address" rows="3"></textarea>
  </div>
    <div class="form-group ">
    <input type="submit" value="Register" class="btn btn-info">
  </div>
     
                                
                                  
                                 
                                 
                                 
</form>
    						
    						
    						
  						</div>
  						
  						<div id="show" class="tab-pane fade">
    						<h3 class='text-center'>Users List</h3>
    						<div class="table-responsive">
    						<table class="table table-bordered table-hover">
    							<thead>
    								<tr>
    									<th>S.No.</th>
    									<th>Name</th>
    									<th>Email</th>
    									<th>Phone</th>
    									<th>Age</th>
    									<th>Country</th>
    									<th>State</th>
    									<th>City</th>
    									<th>Address</th>
    									<th>Update</th>
    									<th>Delete</th>
    									
    								</tr>
    							</thead>
    							<tbody id=showuserlist>
    								
    							</tbody>
    						</table>
    						</div>
    						
  						</div>
  						
  						
					</div>
					
					
					
					</div>
				</div>
			</div>
			
	</div>
	
	
	
	
<!-- Modal -->
<div id="updateModal" class="modal fade" role="dialog">
  <div class="modal-dialog">

    <!-- Modal content-->
    <form method="post" id="updateform">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal">&times;</button>
        <h4 class="modal-title">Modal Header</h4>
      </div>
      <div class="modal-body">
     

               
  <div class="form-group ">
  <input type=hidden id=myid name='id' />
    <label for="name">Name:</label>
    <input type="text"  class="form-control" placeholder="Enter Name here" id="uname" name="name" required>
  </div>
   <div class="form-group ">
    <label for="email">Email address:</label>
    <input type="email" class="form-control" placeholder="Enter Email id here" name="email" id="uemailid" required>
   
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input type="password" class="form-control" placeholder="Enter password here" name="password" id="upass" required>
  	<span class="input-group-btn">
			        <button id= "show_password" class="btn btn-secondary" type="button">
								<span class="glyphicon glyphicon-eye-open"></span>
							</button>
			      </span>
  </div>
  <div class="form-group ">
    <label for="age">Age:</label>
    <input type="text" class="form-control" onkeypress='return isNumber(event,this.value)' name="age" placeholder="Enter Age here" id="uage" required>
  </div>
  <div class="form-group ">
    <label for="phone">Mobile Number:</label>
    <input type="text" class="form-control" name="phone" onkeypress='return isNumber(event,this.value)' placeholder="Enter Mobile Number here" id="unumber" required>
  </div>
                                 
                                 
                                  <div class="form-group">
                                      <label for="Address">Select Country:</label>
  
        <select name="country" class="form-control countries" id="ucountryId" name="country" required="required">
<option value="Select Country">Select Country</option>
</select>
    </div>
 <div class="form-group"> 
     <label for="Address">Select State:</label>
  
        <select name="state" class="form-control states" id="ustateId" name="state" required="required">
<option value="">Select State</option>
</select>
 
</div>
 <div class="form-group"> 
   <label for="Address">Select City:</label>
  
        <select name="city" class="form-control cities" id="ucityId" name="city" required="required">
<option value="">Select City</option>
</select>
 </div>
<div class="form-group ">
    <label for="Address">Enter Street Address:</label>
    <textarea required  class="form-control" placeholder="Enter Address here" name="street_address" id="uaddress" rows="3"></textarea>
  </div>
    <div class="form-group ">
    
  </div>
     
                                
                                  
                                 
                                 
                                 


	
      </div>
      <div class="modal-footer">
        <input type="submit" value="Update" class="btn btn-info"><button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
      </div>
    </div>
</form>
  </div>
</div>
	

</body>
</html>