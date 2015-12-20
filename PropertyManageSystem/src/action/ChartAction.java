package action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import Model.Chart;
import service.IChartService;

import javax.annotation.Resource;

@Action (value="chartAction",results={
		@Result(name="list",type="redirectAction",location="chartAssign!list"),
		@Result(name="suc",location="/index.jsp")
		})
		
@Controller
public class ChartAction {

	
	@Resource(name = "chartService")
	private IChartService chartService;
	
	
	private Chart chart;
	
	private String chartId;
	
	
	public Chart getChart() {
		return chart;
	}
	public void setChart(Chart chart) {
		this.chart = chart;
	}
	public String getChartId() {
		return chartId;
	}
	public void setChartId(String chartId) {
		this.chartId = chartId;
	}
	
	
	
	public String add(){
		chartService.addoredit(chart);
		return "list";
	}
	public String edit(){
		chartService.addoredit(chart);
		return "list";
	}
	public String delete(){
		chartService.deletebyid(Integer.parseInt(chartId));
		return "list";
	}
}
