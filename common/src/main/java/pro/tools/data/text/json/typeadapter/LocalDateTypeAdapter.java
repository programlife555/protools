package pro.tools.data.text.json.typeadapter;

import org.google.gson.stream.JsonReader;
import org.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateTypeAdapter extends ABasicTypeAdapter<LocalDate> {

    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    public LocalDate reading(JsonReader jsonReader) throws IOException {
        jsonReader.beginObject();
        jsonReader.nextName();
        LocalDate localDate;
        String value = jsonReader.nextString();
        localDate = LocalDate.parse(value, DATE_FORMATTER);
        jsonReader.endObject();
        return localDate;
    }

    @Override
    public void writing(JsonWriter jsonWriter, LocalDate value) throws IOException {
        jsonWriter.beginObject().name("value").value(value.format(DATE_FORMATTER)).endObject();
    }
}
