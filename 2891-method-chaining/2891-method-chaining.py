import pandas as pd

def findHeavyAnimals(animals: pd.DataFrame) -> pd.DataFrame:
    filtered = animals[animals['weight'] > 100]
    
    # Sort the filtered animals by weight in descending order
    sorted_animals = filtered.sort_values(by='weight', ascending=False)
    
    # Select the 'name' column
    result = sorted_animals[['name']]
    
    return result