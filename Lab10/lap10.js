var http = require('http');
var url = require('url');
var path = require('path');
//Create Data Array
var schedule=[
    {day:"Sunday", reserved:false, group:null},
      {day:"Monday", reserved:false, group:null},
        {day:"Tuesday", reserved:false, group:null},
          {day:"Wednesday", reserved:false, group:null},
            {day:"Thursday", reserved:false, group:null} 
            //No , at the last one !!!!!!!!!
];

//Configure HTTP Server
var server = http.createServer(function(request, response){
    //parse URL
    var q = url.parse(request.url,true);
    
    //check request
    if(q.pathname==='/scheduleAppointment.html'){
         response.writeHead(200, {"Content-Type":"text/html"});
         response.write("<html><head></head><body>");
         response.write("<h3>Available Days for Appointment in Graduation Project Clinic (12-1) </h3>");
         var nAvailableDays=0;
         var d=0;
         for(d=0;d<schedule.length;d++){
             if(schedule[d].reserved===false){
                 nAvailableDays++;
                 response.write("Day "+(d+1)+":"+schedule[d].day+"<br/>");
             }
         }
         if(nAvailableDays>0){
               response.write("Enter the day number and group name: <br/>");
               response.write("<form action='confirmation.html' method='get'>");
               response.write("<input type='text'  name='day' /> <input type='text'  name='group' />");
               response.write("<button>Schedule</button>");
         }
         else
             response.write("Sorry, all days are reserved");
         
         response.write("</body></html>");
         response.end();
    }
    else if(q.pathname === '/confirmation.html'){
        var qdata = q.query;
        //reserve day
        schedule[qdata.day-1].reserved = true;
        schedule[qdata.day-1].group = qdata.group;
        //output schedule
        console.log("Updated Schedule:"+JSON.stringify(schedule));
        
        //return confirmation
          response.writeHead(200, {"Content-Type":"text/html"});
          response.write("<html><head></head><body>");
          response.write("<h3> Appointment Confirmation </h3>");
          response.write("Your appointment detalis: "+schedule[qdata.day-1].day+", "+schedule[qdata.day-1].group);
          response.write("<br/> <a href='http://localhost:7000/scheduleAppointment.html'> Go Back </a>");
response.end();
    }
    
});
//        .listen(8080)
        
        //listen 
        server.listen(7000,"localhost");
        
        //display a message on the terminal
        console.log("Server running at 7000");