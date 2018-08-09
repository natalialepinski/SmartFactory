<div class="modal fade" id="myModalHorizontal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<!-- Modal Header -->
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span> <span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Solicitar Produção</h4>
			</div>
			<form class="form-horizontal" role="form" action="producao" method="post">
			<!-- Modal Body -->
			<div class="modal-body">
					<div class="form-group">
						<label class="col-lg-3 control-label">Cor</label>
						<div class="col-lg-9">
							<select name="cor" id="cor" class="col-lg-7 control-label">
								<option value="1">Magenta</option>
								<option value="2">Azul</option>
								<option value="3">Branco</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-lg-3 control-label" for="iQuant">Quantidade</label>
						<div class="col-lg-9">
							<select name="iQuant" id="iQuant" class="col-lg-7 control-label">
								<option value="50">50</option>
								<option value="100">100</option>
								<option value="150">150</option>
								<option value="200">200</option>
								<option value="250">250</option>
								<option value="300">300</option>
							</select>
						</div>
					</div>
			</div>

			<!-- Modal Footer -->
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				<input type="submit" class="btn btn-primary" value="Cadastrar">
			</div>
			</form>
		</div>
	</div>
</div>