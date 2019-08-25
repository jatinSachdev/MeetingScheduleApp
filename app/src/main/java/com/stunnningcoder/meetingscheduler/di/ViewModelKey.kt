package com.stunnningcoder.meetingscheduler.di

import androidx.lifecycle.ViewModel
import dagger.MapKey
import java.lang.annotation.RetentionPolicy
import kotlin.reflect.KClass

/**
 * Created by JS on 8/25/19.
 */

@MustBeDocumented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)