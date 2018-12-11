/*
 * Copyright (c) 2016 Ha Duy Trung
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.hidroh.materialistic.test.shadow;

import android.view.animation.Animation;

import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

@Implements(value = Animation.class, inheritImplementationMethods = true)
public class ShadowAnimation {
    private Animation.AnimationListener listener;

    @Implementation
    public void setAnimationListener(Animation.AnimationListener listener) {
        this.listener = listener;
    }

    public Animation.AnimationListener getAnimationListener() {
        return listener;
    }
}
