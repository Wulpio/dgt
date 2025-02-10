package com.wulpio.dgt.core.listener.model;

import java.io.Serializable;

public record TransactionMessage(Long id,
                                 String algorithm)
        implements Serializable {
}