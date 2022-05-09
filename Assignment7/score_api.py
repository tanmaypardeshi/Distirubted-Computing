from flask import Flask, jsonify

app = Flask(__name__)

num_win = 0
num_loss = 0
num_tie = 0


@app.route('/', methods=['GET'])
def help():
    return jsonify(
        {
            'Routes available': [
                {'name': 'add_win', 'method': 'POST'},
                {'name': 'add_loss', 'method': 'POST'},
                {'name': 'add_tie', 'method': 'POST'},
                {'name': 'check_score', 'method': 'GET'}
            ]
        }
    )


@app.route('/add_win', methods=['POST'])
def addwin():
    global num_win
    num_win += 1
    return jsonify(
        {
            'Win Count': num_win
        }
    )


@app.route('/add_loss', methods=['POST'])
def addloss():
    global num_loss
    num_loss += 1
    return jsonify(
        {
            'Loss Count': num_loss
        }
    )


@app.route('/add_tie', methods=['POST'])
def addtie():
    global num_tie
    num_tie += 1
    return jsonify(
        {
            'Tie Count': num_tie
        }
    )


@app.route('/check_score', methods=['GET'])
def score():
    return jsonify(
        {
            'Wins': num_win,
            'Losses': num_loss,
            'Ties': num_tie
        }
    )


if __name__ == '__main__':
    app.run(debug=True)
