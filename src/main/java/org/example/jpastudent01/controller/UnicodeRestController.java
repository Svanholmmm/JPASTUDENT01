package org.example.jpastudent01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicodeRestController {
    @GetMapping("/unicode/{i}")

    public String unicodeToChar(@PathVariable int i) {

        char c = (char) i;

        return "unicode=" + i + " char=" + c;

    }

    @GetMapping("/char/{c}")
    public String charToUnicode(@PathVariable char c) {
        int unicode = (int) c;
        return "char=" + c + " unicode=" + unicode;
    }

    @GetMapping("/range/{start}/{count}")
    public String charRange(@PathVariable char start, @PathVariable int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            char c = (char) (start + i);
            sb.append(c);
        }
        return sb.toString();
    }

}

