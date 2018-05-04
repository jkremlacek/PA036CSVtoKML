# PA036CSVtoKML

Java app for creating KML file with points specified in CSV file

## Build

To build this project run:

`gradle jar`

## Usage

Prepare input CSV files and run with:

`java -jar PA036CSVtoKML *output.kml path* *input.csv* (*input2.csv*...)`

CSV files must have columns in order: *gps_x*,*gps_y*,*name*, *desc1* (,*desc2*,...) (all other column values will be added to point description). Note: values *gps_x* and *gps_y* can contain quotation marks.
