var chartDataDecoded = decodeHTML(chartData);
var jsonChartData = JSON.parse(chartDataDecoded);
var arrLen = jsonChartData.length;
var numericData = [], labels = [];

for(let i = 0; i < arrLen; i++){
    numericData[i] = jsonChartData[i].count;
    labels[i] = jsonChartData[i].label;
}


const ctx = document.getElementById('myChart').getContext('2d');
const myChart = new Chart(ctx, {
    type: 'pie',
    data: {
        labels: labels,
        datasets: [{
            label: '# of count',
            data: numericData,
            backgroundColor: [
                'rgba(255, 99, 132, 0.2)',
                'rgba(54, 162, 235, 0.2)',
                'rgba(255, 206, 86, 0.2)',
            ],
        }]
    },
    options: {
        title: {
            display: true,
            text: "Project Status"
        }
    }
});

function decodeHTML(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}