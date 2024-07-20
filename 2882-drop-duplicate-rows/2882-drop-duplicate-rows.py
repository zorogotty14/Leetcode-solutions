import pandas as pd

def dropDuplicateEmails(customers: pd.DataFrame) -> pd.DataFrame:
    customers_unique = customers.drop_duplicates(subset='email', keep='first')
    return customers_unique