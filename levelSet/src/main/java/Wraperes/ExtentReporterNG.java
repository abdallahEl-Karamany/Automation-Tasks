package Wraperes;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReporterNG implements ITestListener {
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();



    public  ExtentReports getReportObject(){
            String reportPath=System.getProperty("user.dir")+"\\reports\\index.html";
            ExtentSparkReporter reporter=new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("HTML Report");
            reporter.config().setDocumentTitle("Test Result");
            ExtentReports extent=new ExtentReports();
            extent.attachReporter(reporter) ;
            extent.setSystemInfo("Tester","Abdallah Ahmed");
            return extent;
    }
    ExtentReports extent= getReportObject();

    @Override
    public void onTestStart(ITestResult result) {

        test.set(extent.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS,"Test Passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, "Test Failed: " + result.getThrowable().getMessage());

        //test.addScreenCaptureFromPath();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, "Test Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        ITestListener.super.onTestFailedWithTimeout(result);
    }

    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
