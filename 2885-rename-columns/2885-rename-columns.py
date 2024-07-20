import pandas as pd

def renameColumns(students: pd.DataFrame) -> pd.DataFrame:
    new_column_names = {
        'id': 'student_id',
        'first': 'first_name',
        'last': 'last_name',
        'age': 'age_in_years'
    }
    
    # Rename the columns
    students_renamed = students.rename(columns=new_column_names)
    
    return students_renamed