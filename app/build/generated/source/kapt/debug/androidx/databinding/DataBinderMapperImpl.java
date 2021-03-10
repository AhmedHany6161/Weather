package androidx.databinding;

public class DataBinderMapperImpl extends MergedDataBinderMapper {
  DataBinderMapperImpl() {
    addMapper(new com.weatherintake41itiahy.weather.DataBinderMapperImpl());
  }
}
