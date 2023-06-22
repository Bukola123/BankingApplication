package com.bankApp.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UtilityService {


    public static String generateNarration(String sender, String receiver, String channel, String reference) {

        String narration = "Ref: " + reference + " " + channel + " FROM NG " + sender + " IFO " + receiver;

        return narration;

    }
}
