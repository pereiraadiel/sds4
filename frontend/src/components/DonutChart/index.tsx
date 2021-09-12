import { useEffect, useState } from 'react';
import Chart from 'react-apexcharts';
import { SaleSum } from 'types/sale';
import { api } from 'utils/requests';

type ChartData = {
	labels: string[],
	series: number[],
}

const Donut = () => {

	const [chartData, setChartData] = useState<ChartData>({ 
		labels: [],
		series: []
	});

	useEffect(() => {
		api.get('/sales/amount-by-seller')
			.then(result => {	
				const data = result.data as SaleSum[];
				const myLabels = data.map(saleSum => saleSum.sellerName);
				const mySeries = data.map(saleSum => saleSum.sum);
	
				setChartData({ 
					labels: myLabels, 
					series: mySeries
				});
	
				console.log(chartData);
			})
			.catch(err => {
				console.error(err);
			});
	}, [])


	// const mockData = {
	// 	series: [477138, 499928, 444867, 220426, 473088],
	// 	labels: ['Anakin', 'Barry Allen', 'Kal-El', 'Logan', 'Padmé']
	// }

	const options = {
		legend: {
			show: true
		}
	}

  return (
    <Chart
			options={{...options, labels: chartData.labels}}
			series={chartData.series}
			type='donut'
			height='240' 
		/>
  );
}

export default Donut;