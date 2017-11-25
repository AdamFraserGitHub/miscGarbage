var messageTable = document.getElementById("messagesTable");
var tr, td, img, iframe, messageDiv;

for(var i = 0; i < messages.length; i++){
    tr = messageTable.insertRow(i);
    td = tr.insertCell(0);
    messageDiv = document.createElement('div');
    messageDiv.className = "messageContainer";


    //replace with a case,select structure ASAP
    if (messages[i].type == "text"){
        messageDiv.appendChild(document.createTextNode(messages[i].message));
        td.appendChild(messageDiv);
    } 

    else if (messages[i].type == "img"){
        img = document.createElement('img');
        img.src = messages[i].message;
        messageDiv.appendChild(img);
        td.appendChild(messageDiv);
    } 

    else if (messages[i].type == "youtubeEmbed") {
        iframe = document.createElement("iframe");
        iframe.frameBorder = 0;
        iframe.allowFullscreen = true;
        iframe.src = messages[i].message;
        messageDiv.appendChild(iframe);
        td.appendChild(messageDiv);
    } 
    
    else if (messages[i].type == "soundcloudEmbed") {
        iframe = document.createElement("iframe");
        iframe.frameBorder = 0;
        iframe.allowFullscreen = false;
        iframe.src = messages[i].message;
        iframe.height = 300;
        iframe.scrolling = "no";
        messageDiv.appendChild(iframe);
        td.appendChild(messageDiv);
    } 

    else if (messages[i].type == "googleMapEmbed") {
        iframe = document.createElement("iframe");
        iframe.allowFullscreen = true;
        iframe.style = "border:0";
        iframe.frameBorder = 0;
        iframe.height = 450;
        iframe.width = 600;
        messageDiv.appendChild(iframe);
        td.appendChild(messageDiv);
    }
    messageTable.appendChild(tr);
}