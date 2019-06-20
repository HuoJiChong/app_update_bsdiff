

#AUX_SOURCE_DIRECTORY(. BZIP2SRC)

aux_source_directory(. SRC_BZIP)
set(SOURCE_FILES  ${SRC_BZIP})
add_library(bzip2 STATIC ${SRC_BZIP})

#target_include_directories(AndroidDef PUBLIC .)

