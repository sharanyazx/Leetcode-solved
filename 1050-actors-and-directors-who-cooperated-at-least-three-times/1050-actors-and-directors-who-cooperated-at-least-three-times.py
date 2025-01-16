import pandas as pd

def actors_and_directors(actor_director: pd.DataFrame) -> pd.DataFrame:
     grouped = actor_director.groupby(['actor_id', 'director_id']).size().reset_index(name='cooperation_count')
     filtered_pairs = grouped[grouped['cooperation_count'] >= 3]
     return filtered_pairs[['actor_id', 'director_id']]