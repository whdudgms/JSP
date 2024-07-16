var pro = function pro(member){
    str ="<ul>";
        for(let a = 0; a < member.length; a++){
            str += "<li>" +member[a]+ "</li>";
        }
    str+="</ul>"

    return str;
}
