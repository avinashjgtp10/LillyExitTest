<%@ include file="Header.jsp"%>

<div class="container">
	<div class="row">
		<h2 style="text-align: center;">Eli-Lilly test portal Login /
			Register</h2>
	</div>
</div>
<br>
<br>
<div class="container">
	<div class="row">
		<div class="col-md-4 col-md-offset-4">

			<div class="form-body">
				<ul class="nav nav-tabs final-login">
					<li class="active"><a data-toggle="tab" href="#sectionA">{{LoginTitleLog}}</a></li>
					<li><a data-toggle="tab" href="#sectionB">{{LoginTitleReg}}</a></li>
				</ul>
				<div class="tab-content">
					<div id="sectionA" class="tab-pane fade in active">
						<div class="innter-form">

							<form class="sa-innate-form" name="loginForm" method="post"
								ng-submit="UserLogin()">

								<div class="form-group"
									ng-class="{ 'has-error' : loginForm.username.$invalid && !loginForm.username.$pristine }">
									<label>System Id</label> <input type="text" name="username"
										ng-model="user.username" placeholder="Lilly system id"
										required="required">
									<p
										ng-show="loginForm.username.$invalid && !loginForm.username.$pristine"
										class="help-block">Your system id is required.</p>
								</div>

								<div class="form-group"
									ng-class="{'has-error':loginForm.password.$invalid && !loginForm.password.$pristine}">
									<label>Password</label> <input type="password" name="password"
										placeholder="Password" name="password"
										ng-model="user.password" required="required">
									<p
										ng-show="loginForm.password.$invalid && !loginForm.password.$pristine"
										class="help-block">Your password is required.</p>
								</div>

								<button type="submit" ng-disabled="loginForm.$invalid"
									class="btn btn-primary">Sign In</button>
								<a href="">Forgot Password?</a>

							</form>


						</div>
						<div class="clearfix"></div>
					</div>
					<div id="sectionB" class="tab-pane fade">
						<div class="innter-form">

							<form class="sa-innate-form" name="registerForm" method="post"
								ng-submit="UserRegister()">

								<div class="form-group"
									ng-class="{ 'has-error' : registerForm.Rname.$invalid && !registerForm.Rname.$pristine }">
									<label>User Name</label> <input type="text" name="Rname"
										ng-model="user.Rname" placeholder="User name"
										required="required" class="form-control">
									<p
										ng-show="registerForm.Rname.$invalid && !registerForm.Rname.$pristine"
										class="help-block">User name is required.</p>
								</div>
								<div class="form-group"
									ng-class="{'has-error':registerForm.sysid.$invalid && !registerForm.sysid.$pristine}">

									<label>System Id</label> <input type="text"
										class="form-control" placeholder="Enter your lilly system id"
										name="sysid" ng-model="user.sysid" required="required">
									<p
										ng-show="registerForm.sysid.$invalid && !registerForm.sysid.$pristine">System
										id is required.</p>
								</div>


								<div class="form-group">
									<label>Security Question</label> <select
										ng-class="form-control" ng-model="values.SecVal"
										ng-options=" val for val in secQue" ng-change="GetValue()">
									</select>
								</div>


								<div class="form-group"
									ng-class="{'has-error':registerForm.ans.$invalid && !registerForm.ans.$pristine}">
									<label>Answer</label> <input type="password"
										class="form-control" placeholder="Enter your slected question answer" ng-model="user.ans" name="ans"
										required="required"
										>
									<p
										ng-show="registerForm.ans.$invalid && !registerForm.ans.$pristine">Answer
										id is required.</p>

								</div>


								<div class="form-group"
									ng-class="{'has-error':registerForm.password.$invalid && !registerForm.password.$pristine}">
									<label>Password</label> <input type="password" name="password"
										class="form-control" placeholder="Enter password" ng-model="user.password"
										required="required" >
									<p
										ng-show="registerForm.ans.$invalid && !registerForm.ans.$pristine">Password
										id is required.</p>

								</div>

								<button class="btn btn-primary" type="submit"
									ng-disabled="registerForm.$invalid">Register now</button>

								<p>By clicking Register now, you agree to Eli-lilly
									Agreement, Privacy Policy, and Cookie Policy.</p>
							</form>




						</div>

					</div>
				</div>
			</div>

		</div>
	</div>
</div>


<%@ include file="Footer.jsp"%>