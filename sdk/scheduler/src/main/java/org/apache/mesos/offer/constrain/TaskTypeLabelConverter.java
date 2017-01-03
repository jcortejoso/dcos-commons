package org.apache.mesos.offer.constrain;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.mesos.Protos.TaskInfo;
import org.apache.mesos.offer.TaskException;
import org.apache.mesos.offer.TaskUtils;

/**
 * Implementation of {@link TaskTypeConverter} which expects a Label which provides the task type.
 */
public class TaskTypeLabelConverter implements TaskTypeConverter {

    /**
     * Returns the task type embedded in the provided {@link TaskInfo}'s labels.
     *
     * @throws IllegalArgumentException if the provided task doesn't have a task type label
     */
    @Override
    public String getTaskType(TaskInfo taskInfo) {
        try {
            return TaskUtils.getTaskType(taskInfo);
        } catch (TaskException e) {
            throw new IllegalArgumentException(String.format(
                    "Unable to extract task type label from provided TaskInfo: %s", taskInfo), e);
        }
    }

    @Override
    public String toString() {
        return String.format("TaskTypeLabelConverter{}");
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }
}