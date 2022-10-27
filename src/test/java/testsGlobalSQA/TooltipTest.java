package testsGlobalSQA;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.utils.R;
import globalSQA.ProgressBar;
import globalSQA.SliderPage;
import globalSQA.Tooltip;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TooltipTest extends AbstractTest {

    @Test
    public void testSlider(){
        SliderPage slider=new SliderPage(getDriver());
        slider.openURL(R.CONFIG.get("URL")+"/sliders/");
        int amountPixels= slider.getPixels();
        System.out.println(amountPixels);
        slider.slideBlueButton();
        System.out.println(slider.getPixels());
        Assert.assertNotEquals(amountPixels,slider.getPixels(),"Color is changed");
    }

    @Test
    public void testTooltip() {
        Tooltip tooltip = new Tooltip(getDriver());
        tooltip.openURL(R.CONFIG.get("URL")+"/tooltip/#Image%20Based");
        tooltip.hoverTextCity();
        Assert.assertTrue(tooltip.isTooltipPresent(), "Tooltip is present");
    }

    @Test
    public void testProgressBar() {
        ProgressBar progressBar = new ProgressBar(getDriver());
        progressBar.openURL(R.CONFIG.get("URL")+"/progress-bar/#Download%20Manager");
        progressBar.clickStartDownloadingBtn();
        Assert.assertTrue(progressBar.checkProcessDownloading());
    }

//    @Test
//    public void test
}
