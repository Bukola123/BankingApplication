package com.bankApp.utils.general.interfaces;

import com.bankApp.utils.general.enums.ProcessType;

public interface Executor {

    Processor getProcessor(ProcessType type);
}
