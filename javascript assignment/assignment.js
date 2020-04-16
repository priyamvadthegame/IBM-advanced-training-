function getBirthYear() {
    var date=new Date();
    var yearEnterdByUser=document.getElementById("getage").value;
    console.log(yearEnterdByUser);
    if(isNaN(yearEnterdByUser)||yearEnterdByUser==null)
    {
        alert("Please Enter a number")
    }
    else
    {
        var birthYear=date.getFullYear()-yearEnterdByUser;
        alert("Your birth year is "+birthYear);
    }

}

function greetUser() {
    var nameEnterdByUser = document.getElementById("getname").value;
    if (nameEnterdByUser == null) {
        alert("Please Enter a name");
    }
    else
    {
        alert("Welcome  "+nameEnterdByUser);
    }
}
function getDivisionAns() {
    var number1 = document.getElementById("getnumber1").value;
    var number2= document.getElementById("getnumber2").value;
    if (number1 == null||number2==null||isNaN(number1)||isNaN(number2)) {
        alert("Please Enter both the number");
    }
    else
    {   if(number2==0)
        {
            alert("Cannot divide by number 0")
        }
        alert("Answer is  "+number1/number2);
    }
}
function getMulTable() {
    var number1=document.getElementById("getnumberformul").value;
    var i=1,j=0;
    var table=document.getElementById("multable");


        for(i=1;i<=10;i++)
        {   j=0;
            var row=document.createElement("tr");
            var cell1=row.insertCell(j++);
            var cell2=row.insertCell(j++);
            var cell3=row.insertCell(j++);
            var cell4=row.insertCell(j++);
            var cell5=row.insertCell(j++);
            cell1.innerHTML=number1;
            cell2.innerHTML="*";
            cell3.innerHTML=i.toString();
            cell4.innerHTML="=";
            cell5.innerHTML=(number1*i).toString();
            table.appendChild(row);
        }
    setTimeout(function() {
        if(confirm("do you want to continue"))
        {   location.reload();

        }
        else
        {
            document.writeln("Thank you for using my application");
        }
    },500);

}
function checkVowel() {
    var char=document.getElementById("checkvowel").value;
    if(char==null)
    {
        alert("Please enter a character to continue");
    }
    else
    {   char=char[0];
        if(char=='a'||char=='e'||char=='i'||char=='o'||char=='u')
        {
            alert("It  is a vowel");
        }
        else
        {
            alert("It is not a vowel");
        }
    }
}