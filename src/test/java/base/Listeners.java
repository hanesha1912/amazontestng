package base;

import org.testng.ITestContext;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;




public class Listeners extends BaseTest implements ITestListener {

	ExtentReports extent = ExtentReporter.getReportObject();
	
	@Override
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO,"Test has started --"+result.getMethod().getMethodName());
		logger.info(" ** Test started **");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS,"Test has passed --"+result.getMethod().getMethodName());
		logger.info(" ** Test success **");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL,"Test has failed --"+result.getMethod().getMethodName());
		//extent.createTest(result.getMethod().getMethodName());
		logger.info(" ** Test failed **");
		
		try {
			test.addScreenCaptureFromPath(getScreenShotPath(result.getMethod().getMethodName(),driver));
			result.getMethod().getMethodName();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		
		logger.info(" ** Test finished **");
		extent.flush();
	}

}
