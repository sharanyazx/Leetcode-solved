import pandas as pd

def order_scores(scores: pd.DataFrame) -> pd.DataFrame:
    rank = scores['score'].rank(method='dense', ascending=False)
    scores['rank'] = rank
    return scores[['score', 'rank']].sort_values('rank')