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
	    		display();
	    	}
        },
        error: function (e) {
        	alert("查询错误");
        }
    });
}

function display(){
	$("#num").html("句子序号:" + doc["num"]);
	$("#orginsentence").html("原句子:" + hightlight(doc["originsentence"]));
	var wordsposContent = "";
	for(var d in doc["words"]){
		wordsposContent +=  "<strong>" + doc["words"][d]["word"] + "</strong>/" + posmapping[doc["words"][d]["pos"]] + "  ";
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

function createcontent(data, position){
	var all_content = "";
	for(var d in data){
		var content = "<div class=\"base\">" + d + "  ";
		for(var p in data[d]["pattern_words"]){
			content += "<strong>" + data[d]["pattern_words"][p]["word"] + "</strong>/" + posmapping[data[d]["pattern_words"][p]["pos"]] + " ";
		}
		content += "<input class=\"btn btn-default\" onclick=tag('"+position+"',"+d+") type=\"submit\" value=\"选定\"></div>";
		all_content += content;
	}
	return all_content
}

function tag(position, index){
	//改变一下
	doc["verbpattern"][position]["pattern"][index]["is_relat"][doc["crowd_size"]]=1;
	doc["crowd_size"] = doc["crowd_size"] + 1;
	$.ajax({
		type:'POST',
		headers:{
			'Accept': 'application/json',
            'Content-Type': 'application/json'
		},
		url:'./crowdone.do',
		data: JSON.stringify(doc),
		dataType: 'json',
		success: function (data) {	
	    	if(data==null){
	    		alter("評測已結束");
	    	}else{
	    		doc = data;
	    		display();
	    	}
        },
        error: function (e) {
        	alert("查询错误");
        }
    });
	
}
var posmapping = {"CC":"连词", "CD":"数词","DT":"限定词", "EX":"存在量词","FW":"外来词", 
		"IN":"介词连词","JJ":"形容词", "JJR":"比较级词","JJS":"最高级词", 
		"LS":"标记","MD":"情态动词", "NN":"名词","NNS":"名词", 
		"NNP":"专有名词","NNPS":"专有名词", "PDT":"前限定词","POS":"所有格标记", 
		"PRP":"人称代词","PRP$":"所有格", "RB":"副词","RBR":"副词", "RBS":"副词",
		"RP":"虚词","SYM":"符号", "TO":"词to","UH":"感叹词", "VB":"动词",
		"VBD":"动词","VBG":"动词", "VBN":"动词","VBP":"动词", "VBZ":"动词",
		"WDT":"Wh限定词","WP":"WH代词", "WP$":"WH代词", "WRB":"WH副词"};

function hightlight(str){
	return str.replace("<e1>", "<span style=\"color:#FF0000\">").replace("</e1>", "</span>").replace("<e2>", "<span style=\"color:#FF0000\">").replace("</e2>", "</span>");
}
