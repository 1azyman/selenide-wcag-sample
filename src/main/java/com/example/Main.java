package com.example;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class Main {

    public static void main(String[] args) throws Exception {
        Configuration.baseUrl = "https://google.com";

        // wave extension
        // https://chrome.google.com/webstore/detail/wave-evaluation-tool/jbbplnpkjmmeebjpijfedlgcdilocofh
        Configuration.browserCapabilities = new ChromeOptions()
                .addExtensions(new File("src/main/resources/wave.crx"));

        open("/");

        WebDriver driver = WebDriverRunner.getWebDriver();

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        // shortcut to open wave (cmd+shift+u)
//        String wave = Keys.chord(cmdCtrl, Keys.SHIFT, "u");
//        new Actions(driver)
//                .sendKeys(wave)
//                .perform();

        new Actions(driver)
                .keyDown(cmdCtrl)
                .keyDown(Keys.SHIFT)
                .sendKeys("u")
                .keyUp(Keys.SHIFT)
                .keyUp(cmdCtrl)
                .perform();

        Thread.sleep(20_000L);
    }
}
