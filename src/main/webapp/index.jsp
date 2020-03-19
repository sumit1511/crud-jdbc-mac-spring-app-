<form action="insertEmployee">
  <div class="container">
    <h1>Register</h1>
    <p>Please fill in this form.</p>
    <hr>

    <label for="name"><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="empName" required>

    <label for="city"><b>City</b></label>
    <input type="text" placeholder="Enter City" name="empCity" required>

    <label for="Age"><b>Age</b></label>
    <input type="text" placeholder="Enter Age" name="empAge" required>

    <label for="Department"><b>Department</b></label>
    <input type="text" placeholder="Enter Department" name="empDept" required>


    <button type="submit">Register</button>
  </div>


</form>
<form action="searchEmployee">
  <div class="container">
        <h1>Search Employee Details</h1>
        <p>Please enter Employee ID</p>
        <hr>
        <label for="empId"><b>Employee ID Number</b></label>
        <input type="text" placeholder="Enter Employee Id Number" name="empId" required>
        <button type="submit">Search</button>
      </div>
</form>

</form>
<form action="updateEmployee">
  <div class="container">
        <h1>Update Employee Details</h1>
        <p>Please enter Employee Update Name </p>
        <hr>
        <label for="empId"><b>Employee ID Number</b></label>
        <input type="text" placeholder="Enter Employee Id Number" name="empId" required>
        <label for="name"><b>Name</b></label>
        <input type="text" placeholder="Enter Name" name="empName" required>
        <button type="submit">Update</button>
      </div>
</form>

<form action="deleteEmployee">
  <div class="container">
        <h1>Delete Employee Details</h1>
        <p>Please enter Employee ID</p>
        <hr>
        <label for="empId"><b>Employee ID Number</b></label>
        <input type="text" placeholder="Enter Employee Id Number" name="empId" required>
        <button type="submit">Search</button>
      </div>
</form>
</form>
<form method="get" action="readAllEmployee">
 <h1>All Employee Details Reader</h1>
  <div class="container">
        <button type="submit">Reader</button>
   </div>
</form>