package com.digitalbuddha.daodemo.reddit.data.model;

import org.immutables.value.Value;

/**
 * Created by brianplummer on 12/19/15.
 */
@Value.Immutable
public abstract class Children {
    public abstract PostData data();
}
