***service สำหรับลงทะเบียน

POST : http://localhost:8080/api/register/addUser

Headers : key = Username
	    value = Krungsri

Body Json Request :  {
    				            "cid": "7585456176478",
   		 		              "title": "นางสาว",
    		 	            	"firstName": "ธนัญญา",
    		 		            "lastName": "จิตอ่ำ",
   		 	              	"mobile": "0871597764",
  	       	           	"gender": "F",
   		 		              "birthDate": "1996-01-27",
   		 	              	"salary": "35000"
			                }


***service สำหรับเรียกข้อมูล user หลังลงทะเบียน

POST : http://localhost:8080/api/register/getUser

Headers : key = Username
	    value = Krungsri

Body Json Request :  {
    			            	"cid": "7585456176478",
    			            	"firstName": "",
    			            	"lastName": ""
			                }
