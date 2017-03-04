var doc = null;

function getOneDoc(){
	$.ajax({
		type:'POST',
		headers:{
			'Accept': 'application/json',
            'Content-Type': 'application/json'
		},
		url:'./getonedoc.do',
		data: JSON.stringify({}),
		dataType: 'json',
		success: function (data) {	
	    	if(data==null){
	    		alter("評測已結束");
	    	}else{
	    		doc = data;
	    		$("#num").html("句子序号:" + doc["num"]);
	    		$("#orginsentence").html("原句子:" + doc["originsentence"]);
	    		var wordsposContent = "";
	    		for(var d in doc["words"]){
	    			wordsposContent +=  "<strong>" + doc["words"][d]["word"] + "</strong>/" + doc["words"][d]["pos"] + "  ";
	    		}
	    		$("#wordspostag").html("词和词性:" + wordsposContent);
	    		$("#classification").html("分类标签:" + doc["origintag"]);
	    		var left = doc["verbpattern"]["left"]["pattern"];
	    		$("#patternleft").html("<div class=\"base\">左<div>" + createcontent(left, "left"));
	    		var middle = doc["verbpattern"]["middle"]["pattern"];
	    		$("#patternmiddle").html("<div class=\"base\">中<div>" + createcontent(middle, "middle"));
	    		var right = doc["verbpattern"]["right"]["pattern"];
	    		$("#patternright").html("<div class=\"base\">右<div>" + createcontent(right, "right"));
	    	}
        },
        error: function (e) {
        	alert("查询错误");
        }
    });
}

function createcontent(data, position){
	var all_content = "";
	for(var d in data){
		var content = "<div class=\"base\">" + d + "  ";
		for(var p in data[d]["pattern_words"]){
			content += "<strong>" + data[d]["pattern_words"][p]["word"] + "</strong>/" + data[d]["pattern_words"][p]["pos"] + " ";
		}
		content += "<input type=\"button\" onclick=\"tag(\""+position+"\", "+d+")\" name=\"Submit\" value=\"选定\"></div>";
		all_content += content;
	}
	return all_content
}

function tag(position, index){
	alert(position + " " + index);
}

