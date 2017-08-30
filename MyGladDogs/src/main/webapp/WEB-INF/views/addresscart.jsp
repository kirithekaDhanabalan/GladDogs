  <title>address</title>
  <style type="text/css">

.mypanel
{
   background-color: #8B4513;
    text-align: center;
    font-size: 30px;
    font-weight: bold;
    height: 40px;
}

h4 {
  color: hsla(313, 73%, 50%, 1);
  font: normal 28px Varela Round, sans-serif;
  font-weight: bold;
  height: 5px;
  left: 0;
  letter-spacing: 5px;
  margin: -1px 0 0 0;
  position: absolute;
  text-transform: uppercase;
  width: 100%;
  animation: move linear 2000ms infinite;  
}

@keyframes move {
  0% {
    text-shadow:
      4px -4px 0 hsla(0, 100%, 50%, 0.3), 
      3px -3px 0 hsla(0, 100%, 50%, 0.3), 
      2px -2px 0 hsla(0, 100%, 50%, 0.3), 
      1px -1px 0 hsla(0, 100%, 50%, 0.3),
      -4px 4px 0 hsla(240, 100%, 50%, 1), 
      -3px 3px 0 hsla(240, 100%, 50%, 1), 
      -2px 2px 0 hsla(240, 100%, 50%, 1), 
      -1px 1px 0 hsla(240, 100%, 50%, 1)
    ;
  }
  25% {    
    text-shadow:      
      -4px 4px 0 hsla(240, 100%, 50%, 1), 
      -3px 3px 0 hsla(240, 100%, 50%, 1), 
      -2px 2px 0 hsla(240, 100%, 50%, 1), 
      -1px 1px 0 hsla(240, 100%, 50%, 1),
     4px -4px 0 hsla(0, 100%, 50%, 0.3), 
      3px -3px 0 hsla(0, 100%, 50%, 0.3), 
      2px -2px 0 hsla(0, 100%, 50%, 0.3), 
      1px -1px 0 hsla(0, 100%, 50%, 0.3)
    ;
  }
  50% {
    text-shadow:
        4px -4px 0 hsla(0, 100%, 50%, 0.3), 
      3px -3px 0 hsla(0, 100%, 50%, 0.3), 
      2px -2px 0 hsla(0, 100%, 50%, 0.3), 
      1px -1px 0 hsla(0, 100%, 50%, 0.3),
      -4px 4px 0 hsla(240, 100%, 50%, 1), 
      -3px 3px 0 hsla(240, 100%, 50%, 1), 
      -2px 2px 0 hsla(240, 100%, 50%, 1), 
      -1px 1px 0 hsla(240, 100%, 50%, 1)
    ;
  }
  75% {
    text-shadow:
  -4px 4px 0 hsla(240, 100%, 50%, 1), 
      -3px 3px 0 hsla(240, 100%, 50%, 1), 
      -2px 2px 0 hsla(240, 100%, 50%, 1), 
      -1px 1px 0 hsla(240, 100%, 50%, 1),
     4px -4px 0 hsla(0, 100%, 50%, 0.3), 
      3px -3px 0 hsla(0, 100%, 50%, 0.3), 
      2px -2px 0 hsla(0, 100%, 50%, 0.3), 
      1px -1px 0 hsla(0, 100%, 50%, 0.3)  
    ;
  }
  100% {
    text-shadow:
   4px -4px 0 hsla(0, 100%, 50%, 0.3), 
      3px -3px 0 hsla(0, 100%, 50%, 0.3), 
      2px -2px 0 hsla(0, 100%, 50%, 0.3), 
      1px -1px 0 hsla(0, 100%, 50%, 0.3),
      -4px 4px 0 hsla(240, 100%, 50%, 1), 
      -3px 3px 0 hsla(240, 100%, 50%, 1), 
      -2px 2px 0 hsla(240, 100%, 50%, 1), 
      -1px 1px 0 hsla(240, 100%, 50%, 1)
    ;
  }  
}


.btn-submit-fix
{
    background-color: #8B4513;
}
.div-aign
{
    padding-top: 50px;
    margin-left: 300px;

}
.btn-align
{
    margin-top: 20px;
    margin-left: 238px;
}
</style>
<jsp:include page="header.jsp"/>
<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 div-aign ">
                    <!--SHIPPING METHOD-->
                    <div class="panel panel-info">
                        <div class="mypanel">
                        <h4>Shipping Address</h4>
                        </div>
                        <div class="panel-body">
                            <div class="form-group">
                                <div class="col-md-6 col-xs-12">
                                    <strong>First Name:</strong>
                                    <input type="text" name="first_name" class="form-control" value="" />
                                </div>
                                <div class="span1"></div>
                                <div class="col-md-6 col-xs-12">
                                    <strong>Last Name:</strong>
                                    <input type="text" name="last_name" class="form-control" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Address:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" name="address" class="form-control" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>City:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" name="city" class="form-control" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Country:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" class="form-control" name="country" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>State:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" name="state" class="form-control" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Zip / Postal Code:</strong></div>
                                <div class="col-md-12">
                                    <input type="text" name="zip_code" class="form-control" value="" />
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-md-12"><strong>Phone Number:</strong></div>
                                <div class="col-md-12"><input type="text" name="phone_number" class="form-control" value="" /></div>
                            </div>
                            <br>
                            <div class="form-group">
                                <a href="payment"><div class="col-md-6 col-sm-6 col-xs-6 btn-align">
                                    <button type="submit" class="btn btn-primary btn-submit-fix">Proceed</button></a>
                                </div>
                            </div>
                        </div>
                    </div>
        </div>
<jsp:include page="footer.jsp"/>