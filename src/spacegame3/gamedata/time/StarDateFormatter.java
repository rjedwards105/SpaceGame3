package spacegame3.gamedata.time;

import java.nio.file.Path;

public abstract class StarDateFormatter {

        private static final String TIME_FORMAT_FOLDER_URL = "data/timeformat/";
        private Path structurePath;
        private String calenderName;
        private String calenderDay;


        public static StarDateFormatter build(Path storyPath, String calendarName) {
            Path structurePath = storyPath.resolve(TIME_FORMAT_FOLDER_URL + calendarName + ".txt");

            StarDateFormatter formatter = null;

            return switch (calendarName){
                case "iso8601" -> new StarDateCustomCalendar(structurePath, calendarName, calenderDay) {
                    @Override
                    public String toString(StarDate timestamp, String formatName) {
                        return null;
                    }

                    @Override
                    public long toFutureTimestamp(StarDate currentTimestamp, long value, String unit) {
                        return 0;
                    }

                    @Override
                    public String getCalendarName() {
                        return null;
                    }

                    @Override
                    public String calenderDay() {
                        return null;
                    }
                };
                default -> new StarDateCustomCalendar(structurePath);
            };
        }

        public abstract String toString(StarDate timestamp, String formatName);

    public abstract long toFutureTimestamp(StarDate currentTimestamp, long value, String unit);

    public abstract String getCalendarName();
}
