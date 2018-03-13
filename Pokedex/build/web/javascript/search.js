/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



var xmlDOM = new ActiveXObject("Microsoft.XMLDOM");
var count = 0;
var cells = [];
var xmlHttp;
function addRow(tableId, cells) {
    var table = document.getElementById(tableId);
    var newRow = table.insertRow(table.rows.length); //insert by index
    var newCell;
    for (var i = 0; i < cells.length; i++) {
        newCell = newRow.insertCell(newRow.cells.length);
        newCell.innerHTML = cells[i];
    }
    return newRow;
}
function deleteRow(tableId, rowNumber) {
    var table = document.getElementById(tableId);
    if (rowNumber > 0 && rowNumber < table.rows.length) {
        table.deleteRow(rowNumber);
    }
}
function searchNode(node, strSearch, tableName) {
    if (node == null) {
        return;
    }
    if (node.tagName == "") {
        var tmp = node.firstChild.nodeValue;
        if (tmp.indexOf(strSearch, 0) > -1) {
            //Logic

            addRow(tableName, cells);
        }
    }
    var childs = node.childNodes;
    for (var i = 0; i < childs.length; i++) {
        searchNode(childs[i], strSearch, tableName);
    }
}
function searchProcess(tableName) {
    alert("haha");
    alert("haha"+xmlString);
    if (!xmlString) {
        return false;
    }
    if (xmlString) {
        
        xmlDOM.async = false;
        xmlDOM.loadXML(xmlString);
        if (xmlDOM.parseError.errorCode != 0) {
            alert("XML ERROR:" + xmlDOM.parseError.reason);
        } else {
            var table = document.getElementById(tableName);
            var i = 1;
            while (table.rows.length > 1) {
                deleteRow(tableName, i);
            }
            count = 0;
            searchNode(xmlDOM, searchForm.txtName.value, tableName);
        }
    }
}
function travseDOMTree(tableName) {
    var table = document.getElementById(tableName);
    var i = 1;
    while (table.rows.length > i) {
        deleteRow(tableName, i);
    }

    count = 0;
    update();


}
function getXmlHttpObject() {
    var xmlHttp = null;
    try {
        if (window.XMLHttpRequest) {
            xmlHttp = new XMLHttpRequest();
        } else if (window.ActiveXObject) {
            xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
        }

    } catch (e) {
        alert("Can not new XMLHTTPREQUEST");
    }
    return xmlHttp;
}
function update() {

    xmlHttp = getXmlHttpObject();
    if (xmlHttp == null) {
        alert("Browser not supported");
        return;
    }
    var url = "SearchServlet";
    xmlHttp.open("GET", url, true);
    xmlHttp.send(null);
    xmlHttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            alert("OK");
            xmlDOM = xmlHttp.responseText;
            alert(xmlHttp);
            alert(xmlDOM);
            if (xmlDOM.parseError.errorCode != 0) {
                alert("XML ERROR: " + xmlDOM.parseError.reason);
            } else {
                searchNode(xmlDOM, tableName);
            }
        }
    }
}
