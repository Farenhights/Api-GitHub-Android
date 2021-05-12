package eas.api_github_android.data.mapper

interface Mapper<in E, T> {
    fun mapFrom(from: E): T
}