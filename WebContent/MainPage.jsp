<%@ include file="Header.jsp"%>

<div class="container thumbnail">

	<div class="thumbnail headdiv ">
		<span>Lillly Test</span>
		<button class="btn" style="float: right;">Log Out</button>
	</div>
	
	<div class="thumbnail" style="height: 60px;">
		<div class="" style="float: left;">
			<span class="label" style="color: black; font-size: 12px;">Participant
				Name:</span>{{userNameFromDb}} <br> <span class="label"
				style="color: black; font-size: 12px;">Participant Lilly Id:</span>{{userLillyIdFromDb}}
		</div>
		<div class="" style="float: right;">
			<span class="label" style="color: black; font-size: 12px;">Date:</span>{{userNameFromDb}}
			<br> <span class="label" style="color: black; font-size: 12px;">Question:</span>{{userNameFromDb}}
		</div>
	</div>
	
	
	<div class="thumbnail">
	<div class=" thumbnail">
	<span>[Q {{}}]</span>
	<span>Is there any way for the user who is unable to access the invited event from the event publisher. How we can proceed in this case?</span>
	</div>
	
	</div>


</div>



<%@ include file="Footer.jsp"%>
