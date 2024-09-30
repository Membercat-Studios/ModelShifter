package com.codingcat.modelshifter.client.api.renderer.animation;

import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animation.RawAnimation;

import java.util.Objects;
import java.util.function.Predicate;

public record PredicateBasedAnimation<T>(
        int priority,
        @NotNull Predicate<T> predicate,
        @NotNull RawAnimation animation
) {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PredicateBasedAnimation<?> that)) return false;
        return priority == that.priority;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(priority);
    }
}