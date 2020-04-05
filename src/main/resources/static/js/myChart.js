var chartDataStr = decodeHtml(chartData);
var chartJsonArray = JSON.parse(chartDataStr);

var arrayLength = chartJsonArray.length;

var numericData = [];
var labelData = [];

for(var i=0; i < arrayLength; i++){
	numericData[i] = chartJsonArray[i].count;
	labelData[i] = chartJsonArray[i].stage;
}

// For a pie chart
new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    // The data for our dataset
    data: {
        labels: labelData,
        datasets: [{
            label: 'My First dataset',
            backgroundColor: [ "#3cba9f", "#8e5ea2", "#3e95cd"],
//backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
//backgroundColor: ["#8e5ea2", "#3e95cd", "#3cba9f"],
            data: numericData
        }]
    },

    // Configuration options go here
    options: {
    	title: {
    		display: true,
    		text: 'Project Statuses'
    	}

    }
});

// "[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]"
function decodeHtml(html){
	var text = document.createElement("textarea");
	text.innerHTML = html;
	return text.value;
}

